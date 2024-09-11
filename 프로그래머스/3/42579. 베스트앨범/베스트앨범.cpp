/*
1. 속한 노래가 가장 많은 장르 정렬
2. 장르별 노래 벡터 만들기
3. 재생수가 가장 많은 곡 정렬
4. 재생수가 같다면 고유번호가 낮은 노래 먼저 정렬
*/
#include <string>
#include <vector>
#include <unordered_map> 
#include <algorithm>

using namespace std;

bool compare(pair<int,int> a, pair<int,int> b){
    if(a.first == b.first) return a.second < b.second;
    return a.first > b.first;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    unordered_map<string,int> genre_cnt;
    vector<pair<int,string>> sort_genre;
    unordered_map<string,vector<pair<int,int>>> song;
    
    for(int i=0; i<plays.size(); i++){
        // 장르 총 재생 수 계산
        genre_cnt[genres[i]] += plays[i];
        // 장르 내 각 곡별 재생수 및 고유번호 저장
        song[genres[i]].push_back({plays[i], i});
    }
    
    for(auto i: genre_cnt){
        sort_genre.push_back({i.second,i.first});
        sort(song[i.first].begin(), song[i.first].end(), compare);
    }
    
    sort(sort_genre.begin(), sort_genre.end(), greater<>());
    
    for(auto genre : sort_genre){
        answer.push_back(song[genre.second][0].second);
    
        if(song[genre.second].size()>1){
            answer.push_back(song[genre.second][1].second);
        }
    }
    
    return answer;
}