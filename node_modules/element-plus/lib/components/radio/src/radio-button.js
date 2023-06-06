'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

require('../../../utils/index.js');
var radio = require('./radio2.js');
var runtime = require('../../../utils/vue/props/runtime.js');

const radioButtonProps = runtime.buildProps({
  ...radio.radioPropsBase,
  name: {
    type: String,
    default: ""
  }
});

exports.radioButtonProps = radioButtonProps;
//# sourceMappingURL=radio-button.js.map
