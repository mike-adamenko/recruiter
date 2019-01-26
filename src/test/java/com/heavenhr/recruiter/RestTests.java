package com.heavenhr.recruiter;

import com.google.gson.Gson;
import com.heavenhr.recruiter.domain.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestTests {

	private final Gson gson = new Gson();

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnNumberOfApplications() throws Exception {
		this.mockMvc.perform(get("/numberOfApplications/job1")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$").value(2));
	}

	@Test
	public void shouldReturnAllApplications() throws Exception {
		this.mockMvc.perform(get("/applications")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(2));
	}

	@Test
	public void shouldReturn3Offers() throws Exception {
		this.mockMvc.perform(get("/offers")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(3));
	}

	@Test
	public void shouldReturnOfferById() throws Exception {
		this.mockMvc.perform(get("/offers/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.jobTitle").value("job1"))
				.andExpect(jsonPath("$.startDate").value("2019-02-03"))
				.andExpect(jsonPath("$.numberOfApplications").value(2));
	}

	@Test
	public void shouldReturnOfferByJobTitle() throws Exception {
		this.mockMvc.perform(get("/offer").param("jobTitle", "job1")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.jobTitle").value("job1"))
				.andExpect(jsonPath("$.startDate").value("2019-02-03"))
				.andExpect(jsonPath("$.numberOfApplications").value(2));
	}

	@Test
	public void shouldApplyForOffer() throws Exception {
		Application application = new Application();
		application.setCandidateEmail("candidate@gmail.com");
		this.mockMvc.perform(put("/offer/job2").contentType(MediaType.APPLICATION_JSON)
				.content(gson.toJson(application)));
		this.mockMvc.perform(get("/offers/2")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.applications[0].candidateEmail").value("candidate@gmail.com"));
	}

	@Test
	public void shouldReturnApplication() throws Exception {
		this.mockMvc.perform(get("/application").param("candidateEmail", "test1@gmail.com")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.resumeText").value("text1"));
	}

	@Test
	public void shouldReturnApplicationById() throws Exception {
		this.mockMvc.perform(get("/applications/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.resumeText").value("text1"));
	}

	@Test
	public void shouldUpdateApplicationStatus() throws Exception {
		this.mockMvc.perform(post("/application/test1@gmail.com").param("applicationStatus","INVITED")).andDo(print()).andExpect(status().isOk());
		this.mockMvc.perform(get("/applications/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.applicationStatus").value("INVITED"));
	}



}

