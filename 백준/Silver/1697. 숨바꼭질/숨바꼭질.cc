#include <bits/stdc++.h>
using namespace std;
int dist[100002];
int n, k;
int main() {
	cin >> n >> k;
	fill(dist, dist + 100002, -1);
	queue<int>Q;
	Q.push(n);
	dist[n] = 0;
	while (!Q.empty()) {
		int cur = Q.front(); Q.pop();
		//cout << cur <<' '<<"dist:"<<dist[cur]<<'\n';
		int n1 = cur + 1;
		int n2 = cur - 1;
		int n3 = cur * 2;

		if (n1 >= 0 && n1 < 100001 ) {
			if (dist[n1] < 0) {
				Q.push(n1);
				dist[n1] = dist[cur] + 1;
				if (n1 == k) break;
			}
		}
		if (n2 >= 0 && n2 < 100001) {
			if (dist[n2] < 0) {
				Q.push(n2);
				dist[n2] = dist[cur] + 1;
				if (n2 == k) break;
			}
		}
		if (n3 >= 0 && n3 < 100001) {
			if (dist[n3] < 0) {
				Q.push(n3);
				dist[n3] = dist[cur] + 1;
				if (n3 == k) break;
			}
		}
	}
	cout << dist[k];
}