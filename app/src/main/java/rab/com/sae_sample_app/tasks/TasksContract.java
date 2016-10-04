/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package rab.com.sae_sample_app.tasks;

import java.util.List;

import rab.com.sae_sample_app.model.Task;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface TasksContract {

    interface View {

        void showTasks(List<Task> tasks);

        void showNoTasks();

        boolean isActive();
    }

    interface Presenter {

        void loadTasks();

        void addNewTask(String title);

        void deleteTask(Task task);

        void completeTask(Task task);

        void activateTask(Task task);

        void clearTasks();

        void clearCompletedTasks();
    }
}
