package visitcounter.receiver;

import static org.mockito.Matchers.any;
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
		verify(writer, times(1)).writeColumnNamesToCsv(any());
		verify(writer, atLeastOnce()).writeRecordToCsv(any());
		verify(writer, times(1)).closeWriter();
		
		Assert.assertEquals("src/test/resources/test1.csv", argumentCaptorFilePath.getValue());
	}
	
	@Test
	public void whenCalculateDailyFootfallsOverWeekThenThrowNoException() throws IOException
	{
		FootFallModel model1 = new FootFallModel(LocalDate.now(), LocalTime.now());
		FootFallModel model2 = new FootFallModel(LocalDate.of(2020, 1, 1), LocalTime.of(6, 5, 30));
		List<FootFallModel> listRecords = new ArrayList<FootFallModel>();
		listRecords.add(model1);
		listRecords.add(model2);
		
		StatisticsCalculator.calculateDailyFootfallsOverWeek(listRecords, writer);
		verify(writer, times(1)).createWriter(argumentCaptorFilePath.capture());
		verify(writer, times(1)).writeColumnNamesToCsv(any());
		verify(writer, atLeastOnce()).writeRecordToCsv(any());
		verify(writer, times(1)).closeWriter();
		
		Assert.assertEquals("src/test/resources/test2.csv", argumentCaptorFilePath.getValue());
	}
	

	@Test
	public void whenCalculatePeakDailyFootfallsInParticularMonthThenThrowNoException() throws IOException
	{
		FootFallModel model1 = new FootFallModel(LocalDate.of(2020, 1, 2), LocalTime.of(6, 5, 30));
		FootFallModel model2 = new FootFallModel(LocalDate.of(2020, 1, 1), LocalTime.of(6, 5, 30));
		List<FootFallModel> listRecords = new ArrayList<FootFallModel>();
		listRecords.add(model1);
		listRecords.add(model2);
		
		StatisticsCalculator.calculatePeakDailyFootfallsInParticularMonth(1, 2020, listRecords, writer);
		verify(writer, times(1)).createWriter(argumentCaptorFilePath.capture());
		verify(writer, times(1)).writeColumnNamesToCsv(any());
		verify(writer, times(1)).writeRecordToCsv(any());
		verify(writer, times(1)).closeWriter();
		
		Assert.assertEquals("src/test/resources/test3.csv", argumentCaptorFilePath.getValue());
	}
	
	@Test
	public void whenCalculatePeakDailyFootfallsInLastMonthThenThrowNoException() throws IOException
	{
		FootFallModel model1 = new FootFallModel(LocalDate.of(2020, 1, 2), LocalTime.of(6, 5, 30));
		FootFallModel model2 = new FootFallModel(LocalDate.of(2020, 1, 1), LocalTime.of(6, 5, 30));
		List<FootFallModel> listRecords = new ArrayList<FootFallModel>();
		listRecords.add(model1);
		listRecords.add(model2);
		
		StatisticsCalculator.calculatePeakDailyFootFallsInLastMonth(listRecords, writer);
		verify(writer, times(1)).createWriter(argumentCaptorFilePath.capture());
		verify(writer, times(1)).writeColumnNamesToCsv(any());
		verify(writer, times(1)).writeRecordToCsv(any());
		verify(writer, times(1)).closeWriter();
		
		Assert.assertEquals("src/test/resources/test3.csv", argumentCaptorFilePath.getValue());
	}

}
