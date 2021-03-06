define [
  'cs!app'
  'marionette'
], (CDSCeunes, Marionette) ->
  Radios =
    Routers:
      Login: Marionette.Object.extend(
        initialize: (opts) ->
          @router = opts.router
          return
        channelName: 'router-handler'
        radioEvents:
          'login:home': 'routeLoginHome'
        routeLoginHome: ->
          console.log 'Route here'
          CDSCeunes.navigate 'login'
          @router.controller.login()
          return
      )

  Radios.Routers
