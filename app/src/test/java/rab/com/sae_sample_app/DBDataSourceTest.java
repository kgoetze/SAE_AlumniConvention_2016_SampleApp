package rab.com.sae_sample_app;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import rab.com.sae_sample_app.model.datasource.DBDataSource;
import rab.com.sae_sample_app.model.datasource.TasksDataSource;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
public class DBDataSourceTest extends AbstractDataSourceTest {

    @Override
    TasksDataSource createDataSource() {
        return DBDataSource.getInstance(RuntimeEnvironment.application);
    }
}