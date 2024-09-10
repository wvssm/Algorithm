/*
sort 시간복잡도: O(NlogN)
전체 시간복잡도: O(NlogN)
*/
#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <iostream>

using namespace std;


// 속한 노래 많은 장르 체크
unordered_map<string,int> genres_count;
// 장르마다 곡 수, 곡 번호 저장
unordered_map<string,vector<pair<int,int>>> songs;

bool compare(pair<int,int>a, pair<int,int>b){
    if(a.first == b.first){
        return a.second < b.second;
    }
    return a.first > b.first;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    
    // 1. 장르 수 세기, 
    // 2. 장르 벡터에 해당되는 노래, 곡 번호 저장
    // 시간 복잡도 O(N)
    for(int i=0; i<plays.size(); i++){
        genres_count[genres[i]] += plays[i] ;       
        songs[genres[i]].push_back({plays[i],i});
    }
    
    vector<pair<int,string>> cntAndGenres;
    
    // 1. 장르, 곡 벡터에 삽입하기
    // 2. 각 장르 배열 정렬하기 (결국엔 전체 곡을 정렬함 O(NlogN))
    for(auto &i : genres_count){
        cntAndGenres.push_back({i.second, i.first});
        sort(songs[i.first].begin(), songs[i.first].end(), compare);
    }
    
    
    // 장르, 곡 수에따라 정렬하기
    // 시간복잡도 O(GlogG) G -> 장르개수 N보다 훨씬 작음
    sort(cntAndGenres.begin(), cntAndGenres.end(), greater<>());
    
    // 장르 순서에 따라 곡 삽입
    // 1곡 넣을 지, 2곡 넣을 지 결정해서 삽입
    // O(G) 
    for(int i=0; i<cntAndGenres.size(); i++){
         answer.push_back(songs[cntAndGenres[i].second][0].second);
        if(songs[cntAndGenres[i].second].size()>1){
            answer.push_back(songs[cntAndGenres[i].second][1].second);
        }

    }
    return answer;
}