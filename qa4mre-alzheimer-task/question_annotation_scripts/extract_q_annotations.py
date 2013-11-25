#!/usr/bin/env python

import sys, os, csv
from bs4 import BeautifulSoup as bs
from pprint import pprint

DIR='../data/'
OUTFNAME = 'annotations.csv'

def extract_annotations(filename):
    with open(filename) as f:
        contents = f.read()
    soup = bs(contents) 

    annotations = []
    for q in soup.find_all('q'):
        question_type = q.get('q_type')
        question_text = q.find('q_str').get_text()
        all_answers_text = ' '.join(['_A_ ' + a.get_text() for a in q.find_all('answer')])

        text = question_text + ' ' + all_answers_text
        text = text.encode('ascii', errors='ignore')

        q_firstword = question_text.split()[0]

        NONSENSE = 'thisisnonsense'
        unified_answer_firstword = NONSENSE
        for answer in q.find_all('answer'):
            answer_text = answer.get_text().encode('ascii', errors='ignore')

            # ignore 'None of the above' when considering a unified answer first_word
            if answer_text.lower() == 'none of the above':
                continue

            answer_firstword = answer_text.split()[0]
            if unified_answer_firstword == NONSENSE:
                unified_answer_firstword = answer_firstword
            elif answer_firstword != unified_answer_firstword:
                unified_answer_firstword = None

        annotations.append({
            'annotation':question_type, 
            'text':text, 
            'question_firstword':q_firstword,
            'answer_firstword':unified_answer_firstword
            })
    
    return annotations

def crawl_dir(directory):
    files = []
    for item in os.listdir(directory):
        fullpath = os.path.join(directory, item)
        if os.path.isfile(fullpath) and item.endswith('.xml'):
            files.append(fullpath)
        elif os.path.isdir(fullpath):
            files += crawl_dir(fullpath)

    return files

def main():

    annotations = []
    for fname in crawl_dir(DIR):
        annotations += extract_annotations(fname)

    with open(OUTFNAME, 'w') as f:
        writer = csv.DictWriter(f, sorted(annotations[0].keys()))
        writer.writeheader()
        writer.writerows(annotations)
    sys.stderr.write('LOG: wrote {} annotations to {}\n'.format(len(annotations), OUTFNAME))

if __name__ == '__main__':
    main()

