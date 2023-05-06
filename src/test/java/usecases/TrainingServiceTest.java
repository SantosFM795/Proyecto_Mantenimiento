package usecases;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import domain.Training;
import services.TrainingService;
import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })

@Transactional
public class TrainingServiceTest extends AbstractTest{
	
	// System under test -------------------------
	
	@Autowired
	private TrainingService trainingService;
	
	// Tests ------------------------
	@Test
	public void testSaveTraining() {
		Training training, saved;
		Collection<Training> trainings;
		
		training = trainingService.create();
		training.setTitle("e");
		saved = trainingService.save(training);
		trainings = trainingService.findAll();
		Assert.isTrue(trainings.contains(saved));
		
	}

}
