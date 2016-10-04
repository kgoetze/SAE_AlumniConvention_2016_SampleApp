package rab.com.sae_sample_app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import rab.com.sae_sample_app.model.Task;
import rab.com.sae_sample_app.model.datasource.TasksDataSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Abstract test suite which contains all tests for TasksDataSource.
 *
 * Create a non-abstract child of this class which creates
 * a specific TaskDataSource implementation in order to test it.
 */
abstract public class AbstractDataSourceTest {

    TasksDataSource mDataSource;

    abstract TasksDataSource createDataSource();

    @Before
    /**
     * Method that is called before each test.
     * Prepare the test environment here.
     */
    public void setUp(){
        mDataSource = createDataSource();
    }

    @After
    /**
     * Method that is called after each test.
     * Clean up the test environment here.
     */
    public void tearDown(){
        mDataSource.deleteAllTasks();
    }

    @Test
    public void test_saveTask_null() throws Exception {
        // setup test conditions
        Task task = null;

        // call method to test
        mDataSource.saveTask(task);

        // verify results
        assertEquals(0, mDataSource.getTasks().size());
    }

    @Test
    public void test_saveTask() throws Exception {
        // setup test conditions
        Task task1 = new Task("Test Task");
        mDataSource.saveTask(task1);
        Task task2 = new Task("Test Task 2");
        mDataSource.saveTask(task2);

        // call method to test
        List<Task> tasks = mDataSource.getTasks();

        // verify results
        assertEquals(2, tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task2));
    }

    @Test
    public void test_clearCompletedTasks() throws Exception {
        // setup test conditions
        Task task1 = new Task("Test Task 1");
        mDataSource.saveTask(task1);
        Task task2 = new Task("Test Task 2");
        task2.setCompleted(true);
        mDataSource.saveTask(task2);

        // call method to test
        mDataSource.clearCompletedTasks();

        // verify results
        List<Task> tasks = mDataSource.getTasks();
        assertEquals(1, tasks.size());
        assertTrue(tasks.contains(task1));
        assertFalse(tasks.contains(task2));
    }
}