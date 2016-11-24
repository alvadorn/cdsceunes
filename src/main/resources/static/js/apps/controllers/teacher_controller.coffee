define [
  'cs!app'
  'marionette'
  'cs!apps/views/teacher_view'
  'jquery'
], (CDSCeunes, Marionette, View, $) ->
  Controller =
    Teacher: Marionette.Object.extend(
      list: (criterion) ->
        require [
          'cs!entities/common'
          'cs!apps/radios/data/teacher_notify'
          'cs!apps/radios/data/department_notify'
        ], (FilteredCollection) ->
          list_layout = new (View.Layout)
          list_panel = new (View.Panel)
          list_teachers = undefined
          filtered_teachers = undefined

          $.when(CDSCeunes.dataRequest 'teacher:entities').done (teachers) ->
            filtered_teachers = FilteredCollection(
              collection: teachers
              filter: (criterion) ->
                (teacher) ->
                  teacher.get('name').indexOf(criterion) > -1 or teacher.get('login').indexOf(criterion) > -1
            )

            list_teachers = new (View.TeachersList)(collection: filtered_teachers)

            list_layout.on 'render', ->
              list_layout.showChildView 'panelRegion', list_panel
              list_layout.showChildView 'teachersRegion', list_teachers
              return # end show

            list_teachers.on 'childview:teacher:delete', (arg) ->
              console.log 'chegou aqui'
              console.log arg
              filtered_teachers.remove(arg)
              arg.destroy()
              return

            $.when(CDSCeunes.dataRequest 'department:entities').done (departments) ->
              list_layout.on 'childview:teacher:new', ->
                form_view = new (View.Form)(
                  model: CDSCeunes.dataRequest 'teacher:entity:new'
                  departments: departments
                )
                CDSCeunes.regions.showChildView 'dialog', form_view

                form_view.on 'teacher:form:submit', (data) ->
                  console.log "plzor"
                  $.when(CDSCeunes.dataRequest 'teacher:entity:new').done (teacher) ->
                    teacher.save(data,
                      success: (data) ->
                        teachers.add(teacher)
                        CDSCeunes.regions.getRegion('dialog').empty()
                        return
                    )
                    return
                  return
                return
              return

            CDSCeunes.regions.showChildView 'main', list_layout
            return # end promise


          return # end require
        return # end list
    )

  Controller.Teacher
