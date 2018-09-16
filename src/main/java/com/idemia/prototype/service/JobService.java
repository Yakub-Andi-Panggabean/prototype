package com.idemia.prototype.service;

import java.util.List;
import java.util.function.Consumer;

import com.idemia.prototype.domain.Job;
import com.idemia.prototype.domain.JobSearch;

public interface JobService {

  public void displayJobs(JobSearch seach, Consumer<List<Job>> res, Consumer<Exception> err);

}
