/*
* Copyright (c) 2012 Research In Motion Limited.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package nfc.sample.virtual.target.ui;

import java.io.IOException;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.container.MainScreen;
import nfc.sample.virtual.target.Constants;
import nfc.sample.virtual.target.Utilities;

public class ResponseTextScreen extends MainScreen {

    private EditField text = new EditField("Respond with text: ", "Send to other device");
    private ButtonField btn_save_settings = new ButtonField("Apply", ButtonField.CONSUME_CLICK);
    
    private FieldChangeListener listener = new FieldChangeListener() {

        public void fieldChanged(Field field, int context) {
            if (field == btn_save_settings) {
                applySettings();
            }
        }
    };

    private NfcVirtTargScreen _screen;
    
    public ResponseTextScreen(NfcVirtTargScreen screen) {
        setTitle("NfcVirtualTargetFun V" + Constants.MYAPP_VERSION);
        _screen = screen;
        add(text);
        add(btn_save_settings);
        btn_save_settings.setChangeListener(listener);
        
    }
    
    public void save() {
        applySettings();
        try {
            super.save();
        } catch (IOException e) {
        }
    }

    private void applySettings() {
        _screen.setResponse_text(text.getText());
        setDirty(false);
        Utilities.popupMessage("New settings applied");

    }

}
