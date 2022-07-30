# InstaBug Challenge

### A- Test Design : test the andoid app Monefy
https://play.google.com/store/apps/details?id=com.monefy.app.lite

#### Deliverables:
1. Write down all needed high level scenarios( minimum 10 scenarios) to ensure good coverage with different approaches
   ( confirming requirements, negative scenarios). These High level scenarios should contain all details needed to cover this.
2. Write with the scenarios prioritization of such test cases according to their possible business impact.

> list of High level scenarios:


| title | priority |
|-------|----------|
| validate install the app on different devices with different android versions                  | high   |
| validate uninstall and re-install the app on different devices and android versions            | high   |
| validate app UI compatibility with different screen sizes(list all common screen sizes)        | high   |
| validate put app in background, and re-open it at the same state without issues                | high   |
| validate adding a new account using unsubscribed user                                          | high   |
| validate change the account currency using unsubscribed user                                   | high   |
| validate add new incomes using unsubscribed user                                               | high   |
| validate add new expenses using unsubscribed user                                              | high   |
| validate transfer action between accounts using unsubscribed user                              | high   |
| validate that balance being updated correctly according to changes made to income and expenses | high   |
| validate enable and disable budget mode and it's effect on the stored incomes and expenses     | high   |
| validate selecting view (day/week/month/year/all) will show the correct data in home page      | high   |
| validate change app language using unsubscribed user                                           | medium |
| validate app performance using wifi network and cellular data network                          | medium |
| validate app performance in case of a process being interrupted by a phone call                | medium |
| validate transfer action from account to the same account                                      | medium |
| validate app performance with low battery and power saving mode                                | low    |

---
### B- Bug Reporting

#### Deliverables:
1. Write down bugs you found with detailed reports (minimum 6 bugs to be found).
2. Mention(Title,ReproducibleSteps,Attachments,AffectedDevices,Network,Severity,Priority,Impact)
3. Make sure to vary in the types of the bugs found as QA Engineers don’t only work with developers, but also closely
   collaborate with Product Managers.It would be great if you have a strong product sense, you're welcome to spot any
   UX issues in this app and write it down.

> list of Bugs:

| title | Reproducible Steps | Attachments | Affected Devices | Network | Severity | Priority | Impact |
|-------|--------------------|-------------|------------------|---------|----------|----------|--------|
|       |                    |             |                  |         |          |          |        | 
|       |                    |             |                  |         |          |          |        | 
|       |                    |             |                  |         |          |          |        | 
|       |                    |             |                  |         |          |          |        |

---
### C- Test Automation

#### Deliverables:
1. Document Several detailed Test Cases to ensure good coverage by automation.
2. Implement automated tests based on the test cases from the previous step.

> list of automated test cases for google seach page:
1. validate google logo exists 
2. validate search bar exists
3. validate write and clear text in search bar
4. validate that suggestions list appears after enter text in search bar
5. validate search for a special keyword and expecting a result to appear first ex. instabug
6. validate search using empty keywords ex. (add single or multiple spaces then click search)
7. validate that pagination exists at the end of page in case of many results
8. validate that pagination is working 
9. validate search status (time and number of results)
10. search using multiple inputs with different criteria using a data provider ex.(very long input, special chars, meaningless keywords, numbers only)
