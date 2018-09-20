package com.mytaxi.service.car;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mytaxi.dataaccessobject.CarRepository;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.CarManufacturer;
import com.mytaxi.domainvalue.EngineTypes;
import com.mytaxi.exception.EntityNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class DefaultCarServiceIntegrationTest {

	@Mock
	private static CarRepository carRepository;
	
	@TestConfiguration
	static class CarServiceImplTestContextConfiguration {

		@Bean
		public CarService carService() {
			return new DefaultCarService(carRepository);
		}
	}

	@Autowired
	private CarService carService;

	@Before
	public void setUp() {
		CarDO car1 = new CarDO("Car1", 3, EngineTypes.GAS_DIESEL, new CarManufacturer("ComNAME", "2018SV"));
		CarDO car2 = new CarDO("Car2", 2, EngineTypes.ELECTRIC, new CarManufacturer("ComNAME", "2019SV"));
		CarDO car3 = new CarDO("Car3", 2, EngineTypes.GAS_DIESEL, new CarManufacturer("ComNAME", "2017SV"));
		
		//Test1
		car1.setId(1l);
		Mockito.when(carRepository.findById(1l)).thenReturn(Optional.of(car1));

		//Test2
		Mockito.when(carRepository.findByLicensePlate("Car2")).thenReturn(car2);
		
		//Test3
		List<CarDO> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car3);
		car1.setRating(4.7f);
		car3.setRating(5f);
		Mockito.when(carRepository.findByRatingGreaterThanEqual(4.7f)).thenReturn(cars);
		
		//Test4
		Mockito.when(carRepository.findByEngineType(EngineTypes.GAS_DIESEL)).thenReturn(cars);
		
		//Test5
		car1.setAvailable(true);
		car3.setAvailable(true);
		Mockito.when(carRepository.findByAvailable(true)).thenReturn(cars);
		
	}

	@Test //1
	public void whenValidId_thenCarShouldBeFound() throws EntityNotFoundException {
		Long id = 1l;
		CarDO found = carService.find(id);
		
		Assert.assertEquals(found.getId(), id);
	}

	@Test //2
	public void whenValidLicense_thenCarShouldBeFound() throws EntityNotFoundException {
		String licensePlate = "Car2";
		CarDO found = carService.find(licensePlate);

		Assert.assertSame(found.getLicensePlate(), licensePlate);
	}


	@Test //3
	public void whenRating_thenCarsShouldBeFound() throws EntityNotFoundException {
		List<Float> ratings = new ArrayList<>();
		Float rating = 4.7f;
		
		List<CarDO> carsFound = carService.findByRatingGreaterThanEqual(4.7f);
		carsFound.forEach(c -> ratings.add(c.getRating()));
		
        assertThat(ratings, everyItem(greaterThanOrEqualTo(rating)));
	}

	@Test //4
	public void whenSearchEngineType_thenCarsShouldBeFound() throws EntityNotFoundException {
		List<CarDO> cars = new ArrayList<CarDO>();
		cars.add(new CarDO("Car1", 3, EngineTypes.GAS_DIESEL, new CarManufacturer("ComNAME", "2018SV")));
		cars.add(new CarDO("Car3", 3, EngineTypes.GAS_DIESEL, new CarManufacturer("ComNAME", "2017SV")));
		
		List<CarDO> carsFound = carService.find(EngineTypes.GAS_DIESEL);
		
		Assert.assertTrue(carsFound.equals(cars));
	}

	@Test //5
	public void whenSearchAvailability_thenAvailableCarsShouldBeFound() throws EntityNotFoundException {
		List<CarDO> cars = new ArrayList<CarDO>();
		cars.add(new CarDO("Car1", 3, EngineTypes.GAS_DIESEL, new CarManufacturer("ComNAME", "2018SV")));
		cars.add(new CarDO("Car3", 3, EngineTypes.GAS_DIESEL, new CarManufacturer("ComNAME", "2017SV")));
		
		boolean available = true;
		List<CarDO> carsFound = carService.find(available);

		Assert.assertEquals(cars, carsFound);
	}

}