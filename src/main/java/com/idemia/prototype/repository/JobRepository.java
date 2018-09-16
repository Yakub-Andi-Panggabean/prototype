package com.idemia.prototype.repository;

import java.util.List;
import java.util.function.Consumer;

import com.idemia.prototype.domain.Job;
import com.idemia.prototype.domain.JobSearch;

public interface JobRepository {

  void getNearbyJobs(JobSearch search, Consumer<List<Job>> jobs, Consumer<Exception> err);

}
