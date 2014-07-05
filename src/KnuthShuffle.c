/*
Knuth Shuffle implemented in C
Representing cards as unique numbers in an array (for now)
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "KnuthShuffle.h"

int main()
{
    int cards[52];
    int n = sizeof(cards) / sizeof(cards[0]);

    for (int i=0; i<n; i++)
    {
        cards[i] = i;
    }

    printDeck(cards, n);
    knuthShuffle(cards, n);
    printDeck(cards, n);
}


void knuthShuffle(int cards[], int n)
{
    srand(time(NULL));
    int i;

    for (int j=n-1; j>0; j--)
    {
        i = rand() % (i + 1);
        swap(&cards[i], &cards[j]);
    }
}


void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}


void printDeck(int cards[], int n)
{
    for (int i=0; i<n; i++)
    {
        printf("%d ", cards[i]);
    }
    printf("\n");
}