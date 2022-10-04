import spock.lang.Specification

class GroovyExerciseSpec extends Specification{

    /*
    Exercise 1:
    Create a test to assert that the method formatDate() defined below returns expected result.
    hint: use given, when and then or expect
     */
    def 'Use of assertion'(){
        //add code here
    }

    /*
    Exercise 2:
    Create a new Employee object and add to the given list using groovy '<<'
    Assert the new size of the list
    Assert that first employee is age 21
     */
    def 'Using Groovy lists'(){
        given:
           def listOfEmployees = [new Employee(name:"employee1",age:18)]
        when: 'a new employee is added'
            //add code here
        then: 'size of list of employees is as expected'
            //add code here
        then: 'first employee is below 21'
            //add code here
            //hint: use groovy way of accessing fields
    }

    /*
    Exercise 3:
    Replace the role of the trainee employee in the given map to 'manager'
     */
    def 'Using Groovy maps'(){
        given: 'a map of employees and their roles'
            def employeeRoles = ["employee1":"Supervisor","employee2":"Trainee"]
        when: 'element is replaced'
            //add code here
        then: ''
            //add code here
    }

//    /*
//    Exercise 4:
//    Complete the following test using Groovy closures
//     */
//    def 'Using Groovy closures'(){
//        given: 'list of employees'
//            def listOfEmployees = [new Employee(name:"employee1",age:18),
//                                                new Employee(name:"employee2",age:45)]
//        and: ''
//            def checkEmployeeUnder25 = //add code here
//        when: 'all employees are checked'
//            def allEmployeesAreUnder25 = listOfEmployees.every(checkEmployeeUnder25)
//        then: 'result is as expected'
//            assert allEmployeesAreUnder25 == false
//    }

    /*
    Exercise 5:
    Complete the following test to satisfy the 'then' label
     */
    def 'Using Mocks'(){
        given: 'a mock payroll service with a salary of'
            //add code here
        and: 'an employee using that mock PayrollService'
            def employee = new Employee()
            //add code here
        when: 'send salary method is called'
            employee.sendSalary()
        then: 'the method to record payment is called once'
        //make below more strict
            1 * mockPayrollService.recordPayment(*_)
    }

    /*
    Exercise 6:
    Complete the test with 3 scenarios wherein a and b are added
    hint: use of data pipes or list with '<<'
     */
/*    def 'Testing with multiple scenarios'(){
        when: '#a and #b is added'
            def result = a + b
        then: 'result is as expected'
             assert result == expectedResult
        where:
            //add code here
    }*/

//---------------------------------------------------------------------------------------------------------

    /*
    The following methods and classes are used for the tests above.
     */
    def formatDate(def date, def month, def year) {
        return "$date-$month-$year"
    }

    class Employee {
        PayrollService payroll
        String name
        int age

        int getBasicSalary(){
            return payroll.getBasicSalary()
        }

        void sendSalary(){
            payroll.recordPayment(basicSalary)
        }
    }

    interface PayrollService {
        void recordPayment(int amount)
        int getBasicSalary()
    }
}
