
; Get the Jenkins workspace path from the environment variable
Global $workspacePath = EnvGet("WORKSPACE")
;EnvGet Function: EnvGet("WORKSPACE") retrieves the path to the Jenkins workspace where your project files are checked out.
;File Path: The $filePath variable constructs the full path to your Excel file located in the Downloads folder of the Jenkins workspace.

; Set focus to the "Open" dialog's Edit control
ControlFocus("Open", "", "Edit1")

; Set the path to the file in the Downloads folder
Global $filePath = $workspacePath & "\Downloads\download.xlsx"

; Set the text in the Edit control to the file path
ControlSetText("Open", "", "Edit1", $filePath)

; Click the "Open" button to confirm the file selection
ControlClick("Open", "", "Button1")


