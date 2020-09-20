package visitcounter.receiver;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StatisticsCalculatorTest {
	
	@Mock
	FootFallStatisticsCsvWriter writer;
	
	ArgumentCaptor<String> argumentCaptorFilePath = ArgumentCaptor.forClass(String.class);


	@Test
	public void whenCalculateAverageFootfallsPerHourOverDayThenThrowNoException() throws IOException
	{
		FootFallModel model1 = new FootFallModel(LocalDate.now(), LocalTime.now());
		FootFallModel model2 = new FootFallModel(LocalDate.of(2020, 1, 1), LocalTime.of(6, 5, 30));
		List<FootFallModel> listRecords = new ArrayList<FootFallModel>();
		listRecords.add(model1);
		listRecords.add(model2);
		
		StatisticsCalculator.calculateAverageFootfallsPerHourOverDay(listRecords, writer);
		verify(writer, times(1)).createWriter(argumentCaptorFilePath.capture());
		verify(writer, times(1)).writeColumnNamesToCsv(Matchers.<String>anyVararg());
		verify(writer, atLeastOnce()).writeRecordToCsv(Matchers.<String>anyVararg());
		verify(writer, times(1)).closeWriter();
		
		Assert.assertEquals("src/test/resources/test1.csv", argumentCaptorFilePath.getValue());
	}
	
	@Test
	public void whenCalculateDailyFootfallsOverWeekThenThrowNoException() throws IOException
	{
		FootFallModel model1 = new FootFallModel(LocalDate.of(2020, 1, 1), LocalTime.of(6, 5, 30));
		FootFallModel model2 = new FootFallModel(LocalDate.of(2020, 1, 1), LocalTime.of(6, 5, 40));
		FootFallModel model3 = new FootFallModel(LocalDate.of(2020, 1, 2), LocalTime.of(6, 5, 30));
		List<FootFallModel> listRecords = new ArrayList<FootFallModel>();
		listRecords.add(model1);
		listRecords.add(model2);
		listRecords.add(model3);
		
		StatisticsCalculator.calculateDailyFootfallsOverWeek(listRecords, writer);
		verify(writer, times(1)).createWriter(argumentCaptorFilePath.capture());
		verify(writer, times(1)).writeColumnNamesToCsv(Matchers.<String>anyVararg());
		verify(writer, atLeastOnce()).writeRecordToCsv(Matchers.<String>anyVararg());
		verify(writer, times(1)).closeWriter();
		
		Assert.assertEquals("src/test/resources/test2.csv", argumentCaptorFilePath.getValue());
	}
	

	@Test
	public void whenCalculatePeakDailyFootfallsInParticularMonthThenThrowNoException() throws IOException
	{
		FootFallModel model1 = new FootFallModel(LocalDate.of(2020, 1, 31), LocalTime.of(6, 5, 30));
		FootFallModel model2 = new FootFallModel(LocalDate.of(2020, 2, 1), LocalTime.of(6, 5, 40));
		FootFallModel model3 = new FootFallModel(LocalDate.of(2020, 2, 2), LocalTime.of(6, 5, 30));
		List<FootFallModel> listRecords = new ArrayList<FootFallModel>();
		listRecords.add(model1);
		listRecords.add(model2);
		listRecords.add(model3);
		
		StatisticsCalculator.calculatePeakDailyFootfallsInParticularMonth(2, 2020, listRecords, writer);
		verify(writer, times(1)).createWriter(argumentCaptorFilePath.capture());
		verify(writer, times(1)).writeColumnNamesToCsv(Matchers.<String>anyVararg());
		verify(writer, times(1)).writeRecordToCsv(Matchers.<String>anyVararg());
		verify(writer, times(1)).closeWriter();
		
		Assert.assertEquals("src/test/resources/test3.csv", argumentCaptorFilePath.getValue());
	}
	
	@Test
	public void whenCalculatePeakDailyFootfallsInLastMonthThenThrowNoException() throws IOException
	{
		FootFallModel model1 = new FootFallModel(LocalDate.of(2020, 1, 1), LocalTime.of(6, 5, 30));
		FootFallModel model2 = new FootFallModel(LocalDate.of(2020, 1, 2), LocalTime.of(6, 5, 30));
		List<FootFallModel> listRecords = new ArrayList<FootFallModel>();
		listRecords.add(model1);
		listRecords.add(model2);
		
		StatisticsCalculator.calculatePeakDailyFootFallsInLastMonth(listRecords, writer);
		verify(writer, times(1)).createWriter(argumentCaptorFilePath.capture());
		verify(writer, times(1)).writeColumnNamesToCsv(Matchers.<String>anyVararg());
		verify(writer, times(1)).writeRecordToCsv(Matchers.<String>anyVararg());
		verify(writer, times(1)).closeWriter();
		
		Assert.assertEquals("src/test/resources/test3.csv", argumentCaptorFilePath.getValue());
	}

}
