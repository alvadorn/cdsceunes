define(["app", "apps/preferences/list/list_view", "q"], function(CDSCeunes, View, Q) {
  CDSCeunes.module("PreferencesApp.List", function(List, CDSCeunes, Backbone, Marionette, $, _) {
    
    List.Controller = {
     listPreferences: function(criterion) {
        var layoutView = new View.Layout();
        var panelView = new View.Panel();
        var rowsView;
        require(["entities/preferences"], function() {
          Q.all(CDSCeunes.request("preference:entities")).then(function(preferences) {
            
            rowsView = new View.Rows({
              collection: preferences
            });

            layoutView.on("show", function() {
              layoutView.main.show(rowsView);
              layoutView.panel.show(panelView);
            });

            panelView.on("preference:new", function() {
              
            });

            CDSCeunes.regions.main.show(layoutView);
          });
        });
      }
    };

  });
  return CDSCeunes.PreferencesApp.List.Controller;
});