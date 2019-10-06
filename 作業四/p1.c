#include  <stdio.h>
#include  <unistd.h>
#include  <stdlib.h>
#include  <sys/types.h>
#include  <sys/ipc.h>
#include  <sys/sem.h>
#include "awk_sem.h"

main() {
    int i = 0 ;
	int semid1,semid2, semid3,semid4;
    // *** Please insert proper semaphore initialization here
	semid1 = create_sem(".",'A',0);
	semid2 = create_sem(".",'B',0);
	semid3 = create_sem(".",'C',0);
	semid4 = create_sem(".",'D',0);
	
	
    do {
        // *** this is where you should place semaphore 
        
        printf("P1111111111 is here\n"); i++;
        P(semid1);
		
		P(semid1);
		// *** this is where you should place semaphore
   
    }  while (i < 100) ;
}