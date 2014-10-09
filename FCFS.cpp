#include<iostream>
using namespace std;
int main()
{
 int 
arrival[10],burst[10],waiting[10],turn[10],n,k=1,waiting1[10],sum=0,sum1=0;
 float average=0.0,average1=0.0;
 cout<<"\t\tFCFS Scheduling Algorithm\n\n";
 cout<<"Enter the number of processes:";
 cin>>n;

 for(int i=1;i<=n;i++)
 {
  cout<<"\nEnter the Burst time of the process:";
  cin>>burst[i];
  cout<<"Enter the Arrival time of the process:";
  cin>>arrival[i];
 }

 for(int i=2;i<=n;i++)
 {
  waiting1[1]=0;
  
  { 
   waiting[i]=(waiting[i-1]+burst[i-1]);
   waiting1[i]=waiting[i]-arrival[i];
  }
  
 }

 cout<<"\t\tProcess\t\tBurstTime\tArrivalTime\tWaitingTime\tTurnaroundTime\n";
 for(int i=1;i<=n;i++)
 {
  turn[i]=waiting1[i]+burst[i];
  cout<<"\t\t"<<k<<"\t\t"<<burst[i]<<"\t\t"<<arrival[i]<<"\t\t"<<waiting1[i]<<"\t\t"<<turn[i];
  cout<<"\n";
  k++;
  sum=waiting1[i]+sum;
  sum1=turn[i]+sum1;
  }
  average=float(sum)/float(n);
  cout<<"The average Waiting time is:"<<average<<"\n";
  average1=float(sum1)/float(n);
  cout<<"The average turnaround time is:"<<average1<<"\n";
}

