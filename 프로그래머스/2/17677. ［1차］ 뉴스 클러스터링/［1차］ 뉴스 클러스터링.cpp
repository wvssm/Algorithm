#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

int solution(string str1, string str2) {
    int answer = 0;
    int g = 0;
    int h = 0;
    vector<string> v;
    map<string,int> m1;
    map<string,int> m2;
    
    // 문자열 1 쪼개기
    string str = "";
    for(int i=0; i<str1.size(); i++){
        if(isupper(str1[i])) str1[i]=tolower(str1[i]);
        
        str = str + str1[i];
        if(str.size()==2){
            if(str[0]>='a'&&str[0]<='z'&&str[1]>='a'&&str[1]<='z'){
                if(m1[str]==0) v.push_back(str);
                m1[str]++;
            }
            str = str1[i];
        }
    }
    
    // 문자열2 쪼개기 
    str = "";
    for(int i=0; i<str2.size(); i++){
        if(isupper(str2[i])) str2[i]=tolower(str2[i]);
        str = str + str2[i];
        if(str.size()==2){
            if(str[0]>='a'&&str[0]<='z'&&str[1]>='a'&&str[1]<='z'){
                if(m1[str]==0 && m2[str]==0) v.push_back(str);
                m2[str]++;
            }
            str = str2[i];
        }
    }
    
    // 둘 다 공집합일 때
    if(m1.empty() && m2.empty()) return 65536;
    
    // 둘 중 하나가 공집합일 때
    if(m1.empty() || m2.empty()) return 0;
    
    for(int i=0; i<v.size(); i++){
        g += m1[v[i]] < m2[v[i]] ? m1[v[i]] : m2[v[i]];
        h += m1[v[i]] > m2[v[i]] ? m1[v[i]] : m2[v[i]];
    }
    cout << g << " h:" << h;
    answer = ((float)g/h)*65536;
    cout << answer;
    return answer;
}