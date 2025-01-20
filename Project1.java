public class Project1 {
    final static String [][] employeeList = {
            {"1001", "Ashish", "01/04/2009", "e", "R&D", "20000", "8000", "3000"},
            {"1002", "Sushma", "23/08/2012", "c", "PM", "30000", "12000", "9000"},
            {"1003", "Rahul", "12/11/2008", "k", "Acct", "10000", "8000", "1000"},
            {"1004", "Chahat", "29/01/2013", "r", "Front Desk", "12000", "6000", "2000"},
            {"1005", "Ranjan", "16/07/2005", "m", "Engg", "50000", "20000", "20000"},
            {"1006", "Suman", "01/01/2000", "e", "Manufacturing", "23000", "9000", "4400"},
            {"1007", "Tanmay", "12/06/2006", "c", "PM", "29000", "12000", "10000"}
    };

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Provide an employee id!!");
        }

        String empID = args[0];
        boolean found = false;

        for (String[] employee : employeeList) {
            if (employee[0].equals(empID)) {
                found = true;
                String empName = employee[1];
                String empDept = employee[4];
                String empDCode = employee[3];

                int empBasic = Integer.parseInt(employee[5]);
                int empHRA = Integer.parseInt(employee[6]);
                int empIT = Integer.parseInt(employee[7]);

                StringBuilder empDesignation = new StringBuilder();
                int empDA = 0;
                switch (empDCode){
                    case "e" :
                        empDesignation.append("Engineer");
                        empDA = 20000;
                        break;
                    case "c" :
                        empDesignation.append("Consultant");
                        empDA = 32000;
                        break;
                    case "k":
                        empDesignation.append("Clerk");
                        empDA = 12000;
                        break;
                    case "r":
                        empDesignation.append("Receptionist");
                        empDA = 15000;
                        break;
                    case "m":
                        empDesignation.append("Manager");
                        empDA = 40000;
                        break;
                    default:
                        empDesignation.append("Unknown");
                        empDA = 0;
                }
                int empNetSalary = empBasic + empHRA - empIT + empDA;
                System.out.println(empID + "\t" + empName + "\t" + empDept + "\t" + empDesignation.toString() + "\t" + empNetSalary);
                break;
            }
        }
        if (!found){
            System.out.println("Employee with EmpID " + empID + " not found!");
        }
    }
}
