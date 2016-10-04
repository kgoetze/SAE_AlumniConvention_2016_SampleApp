package rab.com.sae_sample_app;

import rab.com.sae_sample_app.model.datasource.InMemoryDataSource;
import rab.com.sae_sample_app.model.datasource.TasksDataSource;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class InMemoryDataSourceTest extends AbstractDataSourceTest {

    @Override
    TasksDataSource createDataSource() {
        return InMemoryDataSource.getInstance();
    }
}