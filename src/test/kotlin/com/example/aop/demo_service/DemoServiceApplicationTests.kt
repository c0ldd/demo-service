package com.example.aop.demo_service

import com.core.api.Service
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor

@SpringBootTest(classes = [DemoServiceApplication::class])
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
annotation class FullAppContextTest

@FullAppContextTest
class DemoServiceApplicationTests(
	val service: Service
) {

	@Test
	fun contextLoads() {
		service.processRequest("request1")
	}

}
