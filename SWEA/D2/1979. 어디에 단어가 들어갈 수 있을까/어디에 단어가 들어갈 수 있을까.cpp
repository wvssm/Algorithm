
#include<iostream>
#include<bits/stdc++.h>

using namespace std;

int maps[16][16];
int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n, k;
		cin >> n >> k;
		
		int horizontal = 0;
		int vertical = 0;
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for(int j=0; j<n; j++)
			{
				cin >> maps[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (maps[i][j] == 1) {
					horizontal += 1;
				}
				if (maps[i][j] == 0 && horizontal != 0) {
					if (horizontal == k) cnt++;
					horizontal = 0;
				}

				if (maps[j][i] == 1) {
					vertical += 1;
				}
				if (maps[j][i] == 0 && vertical != 0) {
					if (vertical == k) cnt++;
					vertical = 0;
				}

			}
			if (horizontal != 0 && horizontal == k) {
				cnt++;
			}
			if (vertical != 0 && vertical == k) {
				cnt++;
			}
			horizontal = 0;
			vertical = 0;
		}
		cout << "#" << test_case << " " << cnt << "\n";
	}
	return 0;
}