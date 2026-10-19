package onthatilepart2;
import com.mycompany.onthatilepart2.Task;
import javax.swing.JOptionPane;

public class OnthatilePart2 {
    public static void main(String[] args) { // First show registration/login from Part 1
        // After login successful:
                // First show registration/login from Part 1
        // After login successful:
        
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks to add?"));
        int totalHours = 0;
        Task[] tasks;
        tasks = new Task[numTasks];
        
        for(int i=0; i<numTasks; i++) {
            String name = JOptionPane.showInputDialog("Task Name:");
            String desc = JOptionPane.showInputDialog("Task Description (max 50 chars):");
            String dev = JOptionPane.showInputDialog("Developer Details (Name Surname):");
            int duration = Integer.parseInt(JOptionPane.showInputDialog("Task Duration (hours):"));
            
            String[] options = {"To Do", "Doing", "Done"};
            String status = (String) JOptionPane.showInputDialog(null, "Task Status:", "Status", 
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            
            Task t = new Task(name, i, desc, dev, duration, status);
            
            if(!t.checkTaskDescription()) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                i--; // repeat this task
                continue;
            }
            
            tasks[i] = t;
            totalHours = t.returnTotalHours(totalHours);
            JOptionPane.showMessageDialog(null, t.printTaskDetails());
        }
        
        JOptionPane.showMessageDialog(null, "Total Hours: " + totalHours);
    }
}