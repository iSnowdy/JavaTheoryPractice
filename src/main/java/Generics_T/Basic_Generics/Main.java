package Generics_T.Basic_Generics;

import Generics_T.Others.Department;
import Generics_T.Others.Employee;

public class Main {
    Department dep = new Department(1, "IT");
    Employee employee = new Employee("Oscar", 25, dep);

    // Without generics, this is not possible. We need a polymorphic envelope
    // We could also achieve the same thing if we gave as parameter something that is related to both
    // Employee and Department. Maybe an abstract class if they had. Or Object. But that would not make sense, as
    // we are losing class semantics (if using Object) and behaviour (methods will be only of Object if we
    // didn't cast the Object to Employee or Department).
    // But casting can be dangerous. Should be avoided if possible
    Envelope<Employee> employeeEnvelope = new Envelope<>(employee);
    Envelope<Department> departmentEnvelope = new Envelope<>(dep);


}