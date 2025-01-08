/*
You are working in a factory, and your task is to schedule the works (jobs) to maximize profit. 
Each job has a unique ID, a deadline (in units of time), and a profit that is earned by completing the job within its deadline. 
There are a limited number of time slots available, and each slot can only hold one job. 

Your task is to Schedule the jobs such that the maximum profit is obtained without missing any job's deadline.

Your goal is to find the maximum profit that can be earned by sequencing the jobs optimally.

Remember, only one task can be executed at a time, and you cannot exceed the available slots.

Input Format:
--------------
Line-1: An integer n representing the number of jobs.
Line-2 to n: Each containing three space-separated integers:
	-Task ID: A unique identifier for each job.
	-Deadline: The latest time (in units) by which the job can be completed.
	-Profit: The profit earned from completing the job.
Line n+1: An integer T representing the number of time slots available (in units of time).

Output Format:
---------------
Line-1: An integer representing the total profit earned by scheduling the jobs.
               
Example 1:
----------
10
1 9 15
2 2 2
3 5 18
4 7 1
5 4 25
6 2 20
7 5 8
8 7 10
9 4 12
10 3 5
15
output =109

Explanation :
-------------
If we choose tasks 1, 3, 4, 5, 6, 7, 8, and 9, we can achieve a maximum profit of 109. 
Note that task 2 and task 10 are left out, because they cannot be done in their associated deadlines.

Example 2:
----------
input = 10
1 9 15
2 2 2
3 5 18
4 7 1
5 4 25
6 2 20
7 5 8
8 7 10
9 4 12
10 3 5
5
output =90
 */
import java.util.*;
class Job{
    int id;
    int deadline;
    int profit;
    Job(int id,int deadline,int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
class JobComparator implements Comparator<Job>{
    public int compare(Job j1,Job j2){
        return j2.profit-j1.profit;
    }
}
public class Day18P1WorkSchedule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        for(int i=0;i<n;i++){
            int id = sc.nextInt();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(id,deadline,profit);
        }
        Arrays.sort(jobs,new JobComparator());
        int T = sc.nextInt();
        int[] slots = new int[T+1];
        int totalProfit = 0;
        for(int i=0;i<n;i++){
            for(int j=jobs[i].deadline;j>0;j--){
                if(slots[j]==0){
                    slots[j] = jobs[i].id;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }
        System.out.println(totalProfit);
    }
}
