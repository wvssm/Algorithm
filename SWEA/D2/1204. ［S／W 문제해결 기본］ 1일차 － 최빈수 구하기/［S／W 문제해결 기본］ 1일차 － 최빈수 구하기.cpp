#include<iostream>
#include<bits/stdc++.h>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	int answer = 0;

	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		vector<int> score(101,0);
		int n;
		int input;
		cin >> n;

		for (int i = 0; i < 1000; i++) {
			cin >> input;
			score[input] += 1;
		}

		int max_val = *max_element(score.begin(), score.end());
		for (int i = 100; i >= 0; i--) {
			if (score[i] == max_val) {
				answer = i;
				break;
			}
		}

		cout << "#" << test_case << " " << answer << '\n';
	}
	return 0;
}