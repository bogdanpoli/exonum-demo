# How to run tests

To execute the tests just browse to the path where the basic-selenium-project is located in your terminal and type `mvn clean verify -Pbrowser-chrome` or execute the tests in your IDE.

# Found issues



## Issue type: Bug

Summary: Can`t save memo and hash

Priority: Major

Severity: Major

Environment: Firefox 56.0.2 (64-bit)

Description:

Steps to Reproduce:

1.       Open https://exonum.com/demo/voting/ page

2.       Press 'VOTE IN ELECTION' button

3.       Select Estonaian Presidential Election and press 'VOTE IN ELECTION' button

4.       Select Candidate and press 'VOTE IN ELECTION' button and confirm in modal window

5.       Scroll down to 'SAVE 3 WORD MEMO AND BALLOT HASH' button and press

ER: Modal window to confirm save appears

AR: Modal window does not appear



## Issue type: Bug

Summary: Settings menu is not avalable

Priority: Minor

Severity: Major

Environment: Chrome 63.0.3239.84 (64-bit)

Description:

Steps to Reproduce:

1.       Open https://exonum.com/demo/voting/ page

2.       Press 'VOTE IN ELECTION' button

3.       Click 'Settings' at bottom right corner

ER: Settings page should be opened

AR: Settings page does not open




