package com.idemia.prototype.service.bean;

import java.util.List;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.idemia.prototype.domain.Job;
import com.idemia.prototype.domain.JobSearch;
import com.idemia.prototype.repository.JobRepository;
import com.idemia.prototype.service.JobService;

public class JobServiceBean implements JobService {

  private static final Logger LOG = LoggerFactory.getLogger(JobServiceBean.class);

  private final JobRepository repository;

  public JobServiceBean(JobRepository repository) {
    super();
    this.repository = repository;
  }

  @Override
  public void displayJobs(JobSearch search, Consumer<List<Job>> res, Consumer<Exception> err) {

    LOG.info("job search : {}", search);

    repository.getNearbyJobs(search, res, err);


  }



}
