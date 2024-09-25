; Set focus to the "Open" dialog's Edit control
ControlFocus("Open", "", "Edit1")

; Get the file path to the Excel file
Global $filePath = @ScriptDir & "\Downloads\download.xlsx"

; Set the text in the Edit control to the file path
ControlSetText("Open", "", "Edit1", $filePath)

; Click the "Open" button to confirm the file selection
ControlClick("Open", "", "Button1")


