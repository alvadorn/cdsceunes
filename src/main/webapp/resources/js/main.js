requirejs.config({
  baseUrl: "resources/js",
  paths: {
    lodash: "vendor/lodash",
    underscore: "vendor/underscore",
    "backbone.babysitter": "vendor/backbone.babysitter",
    "backbone.wreqr": "vendor/backbone.wreqr",
    backbone: "vendor/backbone",
    handlebars: "vendor/handlebars.amd",
    jquery: "vendor/jquery-2.2.0",
    "jquery-ui": "vendor/jquery-ui",
    json2: "vendor/json2",
    localstorage: "vendor/backbone.localStorage",
    marionette: "vendor/backbone.marionette",
    text: "vendor/text"
  },

  shim: {
    lodash: {
      exports: "_"
    },
    backbone: {
      deps: ["jquery", "lodash", "json2"],
      exports: "Backbone"
    },
    marionette: {
      deps: ["backbone"],
      exports: "Marionette"
    },
    "jquery-ui": ["jquery"],
    localstorage: ["backbone"],
    handlebars: {
      exports: "handlebars"
    }
  }
});

require(["app", "apps/login/login_app"], function(CDSCeunes){
  CDSCeunes.start();
});