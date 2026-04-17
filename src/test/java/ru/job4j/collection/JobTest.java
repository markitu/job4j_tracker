package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameDesc() {
        Comparator<Job> compareNameDesc = new JobDescByName();
        int rsl = compareNameDesc.compare(
                new Job("Finish course", 0),
                new Job("Prepare for interview", 1));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAsc() {
        Comparator<Job> compareNameDesc = new JobAscByName();
        int rsl = compareNameDesc.compare(
                new Job("Finish course", 0),
                new Job("Prepare for interview", 1));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriorityDesc() {
        Comparator<Job> compareNameDesc = new JobDescByPriority();
        int rsl = compareNameDesc.compare(
                new Job("Finish course", 0),
                new Job("Prepare for interview", 1));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByPriorityAsc() {
        Comparator<Job> compareNameDesc = new JobAscByPriority();
        int rsl = compareNameDesc.compare(
                new Job("Finish course", 0),
                new Job("Prepare for interview", 1));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriorityAndName() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Finish course", 0),
                new Job("Prepare for interview", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

}