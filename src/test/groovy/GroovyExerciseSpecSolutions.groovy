import spock.lang.Specification

//Sample Solutions
class GroovyExerciseSpecSolutions extends Specification{

    /*
    Exercise 1:
    Create a test to assert that the method formatDate() defined below returns expected result.
     */
    def 'Testing formatDate() method'(){
        given: ''
            def month = 3
            def date = 2
            def year = 1997
        when: ''
            def result = formatDate(date,month,year)
        then: ''
            assert result == "2-3-1997"
    }

    /*
    Exercise 2:
    Create a new Employee object and add to the given list using groovy '<<'
    Assert the new size of the list
    Assert that first employee is age 21
     */
    def 'Using Groovy lists'(){
        given: 'a list of employees'
            def listOfEmployees = [new Employee(name:"employee1",age:18)]
        when: 'a new employee is added'
            listOfEmployees << new Employee(name:"employee2")
        then: 'size of list of employees is as expected'
            assert listOfEmployees.size() == 2
        then: 'first employee is below 21'
            assert listOfEmployees[0].age < 21
    }

    /*
    Exercise 3:
    Replace the role of the trainee employee in the given map to 'manager' using groovy way of accessing an element
     */
    def 'Using Groovy maps'(){
        given: 'a map of employees and their roles'
            def employeeRoles = ["employee1":"supervisor","employee2":"trainee"]
        when: 'element is replaced'
            employeeRoles["employee2"] = "manager"
        then: ''
            assert employeeRoles["employee2"] == "manager"
    }

    /*
    Exercise 4:
    Complete the following test using Groovy closures
     */
    def 'Using Groovy closures'(){
        given: 'list of employees'
            def listOfEmployees = [new Employee(name:"employee1",age:18),
                                   new Employee(name:"employee2",age:45)]
        and: 'a closure to check for employees age'
            def checkEmployeeUnder25 = {Employee employee -> return employee.age < 25}
        when: 'all employees are checked'
            def allEmployeesAreUnder25 = listOfEmployees.every(checkEmployeeUnder25)
        then: 'result is as expected'
            assert allEmployeesAreUnder25 == false
    }

    /*
    Exercise 5:
    Complete the following tests to satisfy the 'then' label of the following test
     */
    def 'Solution A: Using Mocks'(){
        given: 'a mock payroll service with a salary of'
            def mockPayrollService = Mock(PayrollService)
            mockPayrollService.getBasicSalary() >> 4000
        and: 'an employee using that mock PayrollService'
            def employee = new Employee()
            employee.payroll = mockPayrollService
        when: 'send salary method is called'
            employee.sendSalary()
        then: 'the method to record payment is called once'
            1 * mockPayrollService.recordPayment(4000)
    }

    def 'Solution B: Using Mocks'(){
        given: 'a mock payroll service with a salary of'
            def mockPayrollService = Mock(PayrollService)
            1 * mockPayrollService.getBasicSalary() >> 4000
        and: 'an employee using that mock PayrollService'
            def employee = new Employee()
            employee.payroll = mockPayrollService
        when: 'send salary method is called'
            employee.sendSalary()
        then: 'the method to record payment is called once'
            1 * mockPayrollService.recordPayment(4000)
    }



    /*
    Exercise 6:
    Complete the test with 3 scenarios wherein a and b are added
    hint: use of data pipes or list with '<<'
     */
    def 'Testing with multiple scenarios'() {
        when: ''
            def result = a + b
        then: ''
            assert result == expectedResult
        where: ''
            a << [1, 2, 3]
            b << [1, 2, 3]
            expectedResult << [2, 4, 6]
    }

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
