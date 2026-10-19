import { Routes } from '@angular/router';
import {Accounts} from './accounts/accounts';
import {App} from './app';
import {BotUi} from './bot-ui/bot-ui';

export const routes: Routes = [
  { path: '', component: Accounts },
  { path: 'accounts', component: Accounts },
  { path: 'bot', component: BotUi }
];
