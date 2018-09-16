package com.idemia.prototype.repository.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.idemia.prototype.domain.Company;
import com.idemia.prototype.domain.Job;
import com.idemia.prototype.domain.JobSearch;
import com.idemia.prototype.domain.JobSpecialization;
import com.idemia.prototype.domain.Level;
import com.idemia.prototype.domain.Salary;
import com.idemia.prototype.repository.JobRepository;

public class JobRepositoryBean implements JobRepository {

  private static final List<Job> jobData = new ArrayList<>();


  @Override
  public void getNearbyJobs(JobSearch search, Consumer<List<Job>> jobs, Consumer<Exception> err) {

    fullfillJobsList();

    jobs.accept(jobData);


  }


  private void fullfillJobsList() {

    final Company idemia = new Company("Idemia", "AIA Tower 38th floor, South Jakarta");
    final Company a = new Company("Company A", "A Tower 28th floor, North Jakarta");
    final Company b = new Company("Company B", "B Tower 18th floor, West Jakarta");

    final Level staff = new Level(1, "Staff", LocalDateTime.now(), null);
    final Level spv = new Level(1, "Supervisor", LocalDateTime.now(), null);
    final Level manager = new Level(1, "Manager", LocalDateTime.now(), null);

    final JobSpecialization itSpecialization =
        new JobSpecialization("IT/Software", LocalDateTime.now(), null);
    final JobSpecialization accSpecialization =
        new JobSpecialization("Accounting", LocalDateTime.now(), null);

    final Salary staffSalary =
        new Salary("IDR", new BigDecimal(10000000), new BigDecimal(20000000));
    final Salary spvSalary = new Salary("SGD", new BigDecimal(9000), new BigDecimal(15000));
    final Salary managerSalary = new Salary("MYR", new BigDecimal(20000), new BigDecimal(45000));


    jobData.add(new Job(idemia, "Backend Java Developer", "South Jakarta", 10.0, itSpecialization,
        staff, staffSalary, LocalDateTime.now().minusDays(20), LocalDateTime.now().plusDays(3)));

    jobData.add(
        new Job(idemia, "Senior Backend Java Developer", "South Jakarta", 10.0, itSpecialization,
            spv, spvSalary, LocalDateTime.now().minusDays(20), LocalDateTime.now().plusDays(3)));

    jobData.add(new Job(a, "Backend Java Developer", "South Jakarta", 15.0, itSpecialization, spv,
        staffSalary, LocalDateTime.now().minusDays(20), LocalDateTime.now().plusDays(3)));

    jobData.add(new Job(b, "IT Team Leader", "South Jakarta", 10.0, itSpecialization, spv,
        spvSalary, LocalDateTime.now().minusDays(20), LocalDateTime.now().plusDays(3)));

    jobData.add(new Job(a, "Accounting Specialist", "South Jakarta", 10.0, accSpecialization, staff,
        staffSalary, LocalDateTime.now().minusDays(20), LocalDateTime.now().plusDays(3)));

    jobData.add(new Job(a, "Go Developer", "South Jakarta", 10.0, itSpecialization, staff,
        staffSalary, LocalDateTime.now().minusDays(20), LocalDateTime.now().plusDays(3)));

    jobData.add(new Job(a, "TI Manager", "South Jakarta", 10.0, itSpecialization, manager,
        managerSalary, LocalDateTime.now().minusDays(20), LocalDateTime.now().plusDays(3)));

    jobData.add(new Job(a, "Ruby Developer", "South Jakarta", 10.0, itSpecialization, staff,
        staffSalary, LocalDateTime.now().minusDays(20), LocalDateTime.now().plusDays(3)));

    jobData.add(new Job(a, "Python Developer", "South Jakarta", 10.0, itSpecialization, staff,
        staffSalary, LocalDateTime.now().minusDays(20), LocalDateTime.now().plusDays(3)));

    jobData.add(new Job(b, "Ruby Developer", "South Jakarta", 10.0, itSpecialization, staff,
        staffSalary, LocalDateTime.now().minusDays(20), LocalDateTime.now().plusDays(3)));

    jobData.add(new Job(b, "Cobol Developer", "South Jakarta", 15.0, itSpecialization, staff,
        staffSalary, LocalDateTime.now().minusDays(20), LocalDateTime.now().plusDays(3)));

    jobData.add(new Job(a, "Pascal Developer", "South Jakarta", 11.0, itSpecialization, staff,
        staffSalary, LocalDateTime.now().minusDays(20), LocalDateTime.now().plusDays(3)));



  }

}
