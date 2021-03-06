export const addCssBlock = function(block, before = false) {
 const tpl = document.createElement('template');
 tpl.innerHTML = block;
 document.head[before ? 'insertBefore' : 'appendChild'](tpl.content, document.head.firstChild);
};
import '@polymer/iron-icon/iron-icon.js';
import '@polymer/iron-list/iron-list.js';
import '@vaadin/flow-frontend/ironListConnector.js';
import '@vaadin/flow-frontend/ironListStyles.js';
import '@vaadin/flow-frontend/menubarConnector.js';
import '@vaadin/vaadin-accordion/theme/lumo/vaadin-accordion.js';
import '@vaadin/vaadin-app-layout/theme/lumo/vaadin-app-layout.js';
import '@vaadin/vaadin-app-layout/theme/lumo/vaadin-drawer-toggle.js';
import '@vaadin/vaadin-custom-field/theme/lumo/vaadin-custom-field.js';
import '@vaadin/vaadin-details/theme/lumo/vaadin-details.js';
import '@vaadin/vaadin-form-layout/theme/lumo/vaadin-form-item.js';
import '@vaadin/vaadin-form-layout/theme/lumo/vaadin-form-layout.js';
import '@vaadin/vaadin-grid/theme/lumo/vaadin-grid-tree-toggle.js';
import '@vaadin/vaadin-icons/vaadin-icons.js';
import '@vaadin/vaadin-login/theme/lumo/vaadin-login-form.js';
import '@vaadin/vaadin-login/theme/lumo/vaadin-login-overlay.js';
import '@vaadin/vaadin-menu-bar/theme/lumo/vaadin-menu-bar.js';
import '@vaadin/vaadin-progress-bar/theme/lumo/vaadin-progress-bar.js';
import '@vaadin/vaadin-radio-button/theme/lumo/vaadin-radio-button.js';
import '@vaadin/vaadin-radio-button/theme/lumo/vaadin-radio-group.js';
import '@vaadin/vaadin-upload/src/vaadin-upload-file.js';
import '@vaadin/vaadin-upload/theme/lumo/vaadin-upload.js';