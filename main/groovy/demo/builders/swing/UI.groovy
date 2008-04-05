package groovy.demo.builders.swing

import groovy.swing.SwingBuilder
swing = new SwingBuilder()


printAction = swing.action(name:'Print', closure: {
    println swing.message.text
})

frame = swing.frame(title:'Demo') {
    menuBar {
        menu('File') {
             menuItem 'New'
             menuItem 'Open'
        }
    }
    panel {
        label 'Label 1'
        slider()
        comboBox(items:['one','two','three'])
        textField(id:'message',columns:10)
        button   (action: printAction)
    }
}
frame.pack()
frame.show()

