/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/06/08
 */

import { CorpCoopApiClient } from '../../../src/api/arch/corp_coop';
import { API_KEY, HOST } from '../../../src/constants/http_constant';

export const corpCoopTest = 'corpCoopTest';

let username;

describe('corp coop api test', () => {
    const api = new CorpCoopApiClient(API_KEY, HOST, 'v5');

    test('corpCoopDepartList', async () => {
        const corpCoopDepartList = await api.corpCoopDepartList({});
        console.log('corpCoopDepartList result :' + JSON.stringify(corpCoopDepartList));
        expect(corpCoopDepartList['dept_list']).toBeTruthy();
    });

    test('corpCoopMemberList', async () => {
        const corpCoopMemberList = await api.corpCoopMemberList({});
        console.log('corpCoopMemberList result :' + JSON.stringify(corpCoopMemberList));
        expect(corpCoopMemberList['member_list']).toBeTruthy();
        username = corpCoopMemberList['member_list'][0]['username'];
    });

    test('corpCoopUserInfo', async () => {
        const corpCoopUserInfo = await api.corpCoopUserInfo(username);
        console.log('corpCoopUserInfo result :' + JSON.stringify(corpCoopUserInfo));
        expect(corpCoopUserInfo['member']).toBeTruthy();
        expect(corpCoopUserInfo['member']['username']).toEqual(username)
    });
});
