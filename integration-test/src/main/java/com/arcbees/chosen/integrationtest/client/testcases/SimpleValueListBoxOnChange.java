/*
 * Copyright 2015 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.arcbees.chosen.integrationtest.client.testcases;

import com.arcbees.chosen.client.ChosenOptions;
import com.arcbees.chosen.integrationtest.client.domain.CarBrand;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class SimpleValueListBoxOnChange extends SimpleValueListBox {
    public static final String PLACEHOLDER = "Some placeholder";
    public static final String LABEL_ID = "SimpleValueListBoxOnChange-label";

    public SimpleValueListBoxOnChange() {
        super(createChosenOption(), true);
    }

    @Override
    public void run() {
        super.run();

        final Label label = new Label();
        label.getElement().setId(LABEL_ID);

        getListBox().addValueChangeHandler(new ValueChangeHandler<CarBrand>() {
            @Override
            public void onValueChange(ValueChangeEvent<CarBrand> event) {
                CarBrand value = event.getValue();
                label.setText(value == null ? "" : value.name());
            }
        });

        RootPanel.get().add(label);
    }

    private static ChosenOptions createChosenOption() {
        ChosenOptions chosenOptions = new ChosenOptions();
        chosenOptions.setPlaceholderText(PLACEHOLDER);
        chosenOptions.setAllowSingleDeselect(true);

        return chosenOptions;
    }
}
