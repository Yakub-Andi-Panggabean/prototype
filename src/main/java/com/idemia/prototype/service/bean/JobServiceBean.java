package com.idemia.prototype.service.bean;

import java.util.List;
import java.util.function.Consumer;

import com.idemia.prototype.domain.Job;
import com.idemia.prototype.domain.JobSearch;
import com.idemia.prototype.repository.JobRepository;
import com.idemia.prototype.service.JobService;

public class JobServiceBean implements JobService {

  private final JobRepository repository;

  public JobServiceBean(JobRepository repository) {
    super();
    this.repository = repository;
  }

  @Override
  public void displayJobs(JobSearch seach, Consumer<List<Job>> res, Consumer<Exception> err) {

    repository.getNearbyJobs(seach, res, err);


  }



}
