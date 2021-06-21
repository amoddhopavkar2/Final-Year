#include <iostream>
#include <math.h>
#include <string.h>
#define MAX 100
using namespace std;

int e_value[MAX], d_value[MAX], en[MAX];
char message[MAX], temp[MAX];
int prime(int num)
{
    int j = sqrt(num);
    for (int i = 2; i <= j; i++)
    {
        if (num % i == 0)
        {
            return 0;
        }
    }
    return 1;
}

int find_d(int phi_n, int x)
{
    int k = 1;
    while (1)
    {
        k = k + phi_n;
        if (k % x == 0)
        {
            return (k / x);
        }
    }
}

void find_e(int phi_n, int p, int q)
{
    int flag = 0, k = 0;
    for (int i = 2; i < phi_n; i++)
    {
        if (phi_n % i == 0)
        {
            continue;
        }
        flag = prime(i);
        if (flag == 1 && i != p and i != q)
        {
            e_value[k] = i;
            flag = find_d(phi_n, e_value[k]);
            if (flag > 0)
            {
                d_value[k] = flag;
                k++;
            }
            if (k == MAX - 1)
            {
                break;
            }
        }
    }
}

void encrypt(char string[], int n)
{
    int pt, ct;
    int len = strlen(string);
    int key = e_value[0];
    int i = 0, k;
    while (i != len)
    {
        pt = message[i];
        pt = pt - 96;
        k = 1;
        for (int j = 0; j < key; j++)
        {
            k = k * pt;
            k = k % n;
        }
        temp[i] = k;
        ct = k + 96;
        en[i] = ct;
        i++;
    }
    en[i] = -1;
    cout << "\nThe encrypted message is: ";
    for (i = 0; en[i] != -1; i++)
    {
        printf("%c", en[i]);
    }
    cout << endl;
}

void decrpyt(int n)
{
    int pt, ct;
    int key = d_value[0];
    int i = 0, k;
    char message[MAX];
    while (en[i] != -1)
    {
        ct = temp[i];
        k = 1;
        for (int j = 0; j < key; j++)
        {
            k = k * ct;
            k = k % n;
        }
        pt = k + 96;
        message[i] = pt;
        i++;
    }
    message[i] = -1;
    cout << "\nThe decypted message is: ";
    for (i = 0; message[i] != -1; i++)
    {
        printf("%c", message[i]);
    }
    cout << endl;
}

int main()
{
    int flag, p, q, n, phi_n, e;
    int count = 0;
    char string[MAX];
    cout << "\n---RSA ALGORITHM FOR KEY GENERATION AND CIPHER VERIFICATION---" << endl;
    while (flag != 1)
    {
        if (count == 0)
        {
            cout << "\nEnter the first prime number(p): ";
        }
        else
        {
            cout << "\nNot a Prime...\nRe-Enter a valid number: ";
        }
        cin >> p;
        flag = prime(p);
        if (flag != 1)
        {
            count++;
        }
    }

    flag = 0, count = 0;
    while (flag != 1)
    {
        if (count == 0)
        {
            cout << "\nEnter the second prime number(q): ";
        }
        else
        {
            cout << "\nNot a Prime...\nRe-Enter a valid number: ";
        }
        cin >> q;
        flag = prime(q);
        if (flag != 1)
        {
            count++;
        }
    }

    cout << "\nEnter the message: ";
    fflush(stdin);
    cin >> string;
    for (int i = 0; string[i] != '\0'; i++)
    {
        message[i] = string[i];
    }

    n = p * q;
    phi_n = (p - 1) * (q - 1);

    find_e(phi_n, p, q);
    encrypt(string, n);
    decrpyt(n);
}