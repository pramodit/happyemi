/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.happyemi.assignment.main_screen;

import com.happyemi.assignment.pojo.Forecastday;

import java.util.List;

public interface MainView {

    /**
     * <h2>showProgress</h2>
     * This method is used to show progress bar on call of APIS
     */
    void showProgress();

    /**
     * <h2>hideProgress</h2>
     * This method is used to hide progress bar after the call of API success
     */
    void hideProgress();

    /**
     * <h2>addItems</h2>
     * This method is used to ADD DATA TO ADAPTER AFTER api call
     */
    void addItems(List<Forecastday> articleList);


    /**
     * <h2>setCurrentWeather</h2>
     * This method is used to set Current weather data
     * @param temperature temperature in celcius
     * @param location location name.
     */
    void setCurrentWeather(double temperature,String location);


    /**
     * <h2>setError</h2>
     * This method is used to show a toast with the error message from API
     */
    void setError(String message);
}
