#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <iostream>

using namespace std;

unordered_map<string,int> genres_count;
unordered_map<string,vector<pair<int,int>>> songs;

bool compare(pair<int,int>a, pair<int,int>b){
    if(a.first == b.first){
        return a.second < b.second;
    }
    return a.first > b.first;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    
    for(int i=0; i<plays.size(); i++){
        genres_count[genres[i]] += plays[i] ;       
        songs[genres[i]].push_back({plays[i],i});
    }
    
    vector<pair<int,string>> cntAndGenres;
    
    for(auto &i : genres_count){
        sort(songs[i.first].begin(), songs[i.first].end(), compare);
        cntAndGenres.push_back({i.second, i.first});
    }
    
    sort(cntAndGenres.begin(), cntAndGenres.end(), greater<>());
    
    for(int i=0; i<cntAndGenres.size(); i++){
         answer.push_back(songs[cntAndGenres[i].second][0].second);
        if(songs[cntAndGenres[i].second].size()>1){
            answer.push_back(songs[cntAndGenres[i].second][1].second);
        }

    }
    return answer;
}