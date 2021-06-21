#include <stdio.h>
#include <iostream>
#define MAX 10
using namespace std;

int multiplicative_inverse(int a, int m)
{
    a = a % m;
    for (int i = 0; i < m; i++)
    {
        if ((a * i) % m == 1)
        {
            return i;
        }
    }
    return -1;
}

int main()
{
    int a[MAX], n[MAX], m[MAX], m_inv[MAX];
    cout << "\n---CHINESE REMAINDER THEOREM---\n";

    for (int i = 0; i < 3; i++)
    {
        cout << "\na[" << i + 1 << "]: ";
        cin >> a[i];
        cout << "\nn[" << i + 1 << "]: ";
        cin >> n[i];
    }

    int M = 1;
    for (int i = 0; i < 3; i++)
    {
        M = M * n[i];
    }

    cout << "\nM = " << M << endl;

    for (int i = 0; i < 3; i++)
    {
        m[i] = M / n[i];
        cout << "m[" << i + 1 << "] = " << m[i] << "\t";
    }

    cout << endl;
    for (int i = 0; i < 3; i++)
    {
        m_inv[i] = multiplicative_inverse(m[i], n[i]);
        cout << "m'[" << i + 1 << "] = " << m_inv[i] << "\t";
    }

    int X = 0;
    for (int i = 0; i < 3; i++)
    {
        X += a[i] * m[i] * m_inv[i];
    }
    cout << "\n\nX = " << X << " % " << M;
    X = X % M;
    cout << "\n\nX = " << X << endl;
}
