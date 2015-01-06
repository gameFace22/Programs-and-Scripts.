#include<iostream>
using namespace std;
int main()
{
  int temp,iteration=1,q,r0,r1,r2=22,u0=1,u1=0,u2,v0=0,v1=1,v2,a,b;
  cout<<"Extended Eucledian Algorithm \n \n";
  cout<<"Enter the values of a,b \n \n";
  cin>>a>>b;
  if(b>a)
  {
    temp=a;
    a=b;
    b=temp;
  }
  cout<<"Iter"<<"\t"<<"q"<<"\t"<<"r(n-1)"<<"\t"<<"r(n)"<<"\t"<<"r(n+1)"<<"\t"<<"u(n-1)"<<"\t"<<"u(n)"<<"\t"<<"u(n+1)"<<"\t"<<"v(n-1)"<<"\t"<<"v(n)"<<"\t"<<"v(n+1)"<<"\n";
  r0=a;
  r1=b;
  while(r2!=0)
  {
   q=r0/r1;
   r2=r0-(q*r1);
   u2=u0-(q*u1);
   v2=v0-(q*v1);
   cout<<iteration<<"\t"<<q<<"\t"<<r0<<"\t"<<r1<<"\t"<<r2<<"\t"<<u0<<"\t"<<u1<<"\t"<<u2<<"\t"<<v0<<"\t"<<v1<<"\t"<<v2<<"\n \n \n";
   r0=r1;
   r1=r2;
   u0=u1;
   u1=u2;
   v0=v1;
   v1=v2;
   iteration++;     
  }
  cout<<"GCD of two numbers:"<<r0<<"\n";
}
  
  
  
