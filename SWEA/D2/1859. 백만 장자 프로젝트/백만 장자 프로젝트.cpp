#include<bits/stdc++.h>
#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        int n;
        cin >> n;
        vector<int> v;
        int value;
        long long sum = 0;
        for(int i=0; i<n; i++){
            cin>>value;
            v.push_back(value);
        }
        int j = 0;
        long long max_value = -1;
        int max_index = -1;
        while(max_index < n-1){
            long long small_sum = 0;
       		int cnt = 0;
           max_value = (long long)*max_element(v.begin(),v.end());
           max_index = max_element(v.begin(), v.end()) - v.begin();
           for(int i=j; i<max_index; i++){
               small_sum += v[i];
               v[i] = 0;
               cnt ++;
           }
           sum += cnt * max_value - small_sum;
            j = max_index+1;
            v[max_index] = 0;
        }
        
        
        cout << "#" << test_case << " " << sum << '\n';
	}
	return 0;
}