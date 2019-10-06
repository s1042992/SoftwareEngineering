#include  <stdio.h>
#include  <unistd.h>
#include  <stdlib.h>
#include  <sys/types.h>
#include  <sys/ipc.h>
#include  <sys/sem.h>
#include "awk_sem.h"
main() {
    int i = 0 ;
	int semid1,semid2,semid3,semid4;
    // *** please insert proper semaphore initialization here
	semid1 = get_sem(".",'A');
	semid2 = get_sem(".",'B');
	semid3 = get_sem(".",'C');
	semid4 = get_sem(".",'D');
	
    do {
        // *** this is where you should place semaphore 
       
       printf("P222222222 is here\n"); i++ ;
	   V(semid4);
	   P(semid2);
	   V(semid4);
       P(semid2);
       // *** this is where you should place semaphore
   
    }  while (i < 100);
}